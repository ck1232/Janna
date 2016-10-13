<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
{
    "className":      '',
    "orderable":      false,
    "data":           "",
    "defaultContent": '<div style="text-align:center;"><input type="checkbox" name="checkboxId"/></div>'
},
{"data": "userid"},
{"data": "name"},
{"data": "emailaddress"},
{
    "className":      '',
    "orderable":      false,
    "data":           null,
    "defaultContent": '<button name="viewBtn" class="btn btn-info btn-edit" type="submit" form="viewUserForm">View</button>   <button name="editBtn" class="btn btn-info btn-edit" type="submit" form="updateUserForm"><i class="fa fa-pencil"></i> Edit</button>   <button name="assignRoleBtn" class="btn btn-info btn-edit" type="submit" form="datatableForm" formaction="/JJ/assignRole">Assign Role</button>'
},