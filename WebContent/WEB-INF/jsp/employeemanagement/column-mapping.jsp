<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
{
    "className":      '',
    "orderable":      false,
    "data":           "",
    "defaultContent": '<div style="text-align:center;"><input type="checkbox" name="checkboxId"/></div>'
},
{"data": "name"},
{"data": "employmenttypeString"},
{"data": "nationality"},
{"data": "basicsalary"},
{
    "className":      '',
    "orderable":      false,
    "data":           null,
    "defaultContent": '<button name="viewBtn" class="btn btn-primary" type="submit" form="viewEmployeeForm">View</button>' + 
    '<button name="editBtn" class="btn btn-primary" type="submit" form="updateEmployeeForm"><i class="fa fa-pencil"></i> Edit</button>'
    
},