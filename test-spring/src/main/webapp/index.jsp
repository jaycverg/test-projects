<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="css/default.css" rel="stylesheet" />
        <script src="js/jquery.min.js"></script>
        <script src="js/app.js"></script>
        <script>
            App.init("${pageContext.request.contextPath}");
            
            var cols = [
                {name: 'lastname', caption: 'Last Name'},
                {name: 'firstname', caption: 'First Name'},
                {name: 'middlename', caption: 'Middle Name'},
                {name: 'address', caption: 'Address'},
            ];
            App.loadList('#emp-list', cols);
        </script>
    </head>
    <body>
        <table id="emp-list" class="data-table"></table>
        
        <form onsubmit="App.submit(this); return false;">
            <label>
                First Name:
                <input type="text" name="firstName" />
            </label>
            <label>
                First Name:
                <input type="text" name="lastName" />
            </label>
            <button type="submit">Save</button>
        </form>
    </body>
</html>
