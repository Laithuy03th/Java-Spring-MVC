package com.example.demo.controller.admin;

import java.util.List;
import java.util.Optional;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.domain.Product;
import com.example.demo.domain.User;
import com.example.demo.services.ProductService;
import com.example.demo.services.UploadService;
import com.example.demo.services.UserService;

import jakarta.validation.Valid;

@Controller
public class ProductController {

    private final ProductService productService;
    private final UploadService uploadService;

    public ProductController(ProductService productService, UploadService uploadService) {

        this.productService = productService;
        this.uploadService = uploadService;

    }

    @GetMapping("/admin/product")
    public String getProduct(Model model) {
        List<Product> prs = this.productService.fetchProducts();
        model.addAttribute("products", prs);
        return "admin/product/show";
    }

    @GetMapping("/admin/product/{id}")

    public String getProductDetailPage(Model model, @PathVariable long id) {
        Product pr = this.productService.fetchProductById(id).get();
        System.out.println("check id =  " + id);
        model.addAttribute("product", pr);
        model.addAttribute("id", id);

        return "admin/product/detail";
    }

    @GetMapping("/admin/product/create")
    public String getCreateProductPage(Model model) {

        model.addAttribute("newProduct", new Product());
        return "admin/product/create";
    }

    @PostMapping(value = "admin/product/create")
    public String handleCreateProduct(Model model, @ModelAttribute("newProduct") @Valid Product pr,
            BindingResult newProductBindingResult, @RequestParam("laithuyFile") MultipartFile file) {

        // validate
        if (newProductBindingResult.hasErrors()) {
            return "admin/product/create";
        }

        // upload image
        String image = this.uploadService.handleSaveUploadFile(file, "product");

        pr.setImage(image);

        this.productService.createProduct(pr);

        return "redirect:/admin/product";
    }

    @GetMapping("admin/product/update/{id}")
    public String getUserUpdateProductPage(Model model, @PathVariable long id) {
        Optional<Product> currentProduct = this.productService.fetchProductById(id);
        model.addAttribute("newProduct", currentProduct.get());
        return "admin/product/update";
    }

    @PostMapping("admin/product/update")
    public String postUserUpdate(Model model, @ModelAttribute("newProduct") @Valid Product pr,
            BindingResult newProductBindingResult,
            @RequestParam("laithuyFile") MultipartFile file) {

        // validate
        if (newProductBindingResult.hasErrors()) {
            return "admin/product/update";
        }

        //
        Product currentProduct = this.productService.fetchProductById(pr.getId()).get();
        if (currentProduct != null) {
            // upload new image
            if (!file.isEmpty()) {
                String img = this.uploadService.handleSaveUploadFile(file, "product");
                currentProduct.setImage(img);
            }

            currentProduct.setName(pr.getName());
            currentProduct.setPrice(pr.getPrice());
            currentProduct.setQuantity(pr.getQuantity());
            currentProduct.setDetailDesc(pr.getDetailDesc());
            currentProduct.setShortDesc(pr.getShortDesc());
            currentProduct.setFactory(pr.getFactory());
            currentProduct.setTarget(pr.getTarget());

            this.productService.createProduct(currentProduct);

        }
        return "redirect:/admin/product";
    }

    @GetMapping("admin/product/delete/{id}")
    public String getUserDeletePage(Model model, @PathVariable long id) {

        model.addAttribute("id", id);

        // User user = new User();
        // user.setId(id);
        model.addAttribute("newProduct", new Product());
        return "admin/product/delete";
    }

    @PostMapping("admin/product/delete")
    public String postDeleteProduct(Model model, @ModelAttribute("newProduct") Product pr) {
        this.productService.deleteProduct(pr.getId());
        return "redirect:/admin/product";
    }

}