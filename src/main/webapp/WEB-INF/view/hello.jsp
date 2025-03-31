


<!DOCTYPE html>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>

    <!-- Latest compiled and minified CSS --> 
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" 
rel="stylesheet"> 
<!-- Latest compiled JavaScript --> 
<script 
src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
  
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script> 
 <link href="/css/demo.css" rel="stylesheet">
</head>
<body>
    Today's date: <%= (new java.util.Date()).toLocaleString()%>
    <h1>
        <c:out value="${thuy}" /> 
        ${thuy} 
    </h1>
    <button class="btn btn-success">Submit</button>

   
</body>
</html>