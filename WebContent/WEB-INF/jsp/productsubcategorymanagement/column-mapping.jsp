<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
{
    "className":      '',
    "orderable":      false,
    "data":           "",
    "defaultContent": '<div style="text-align:center;"><input type="checkbox" name="checkboxId"/></div>'
},
{"data": "name"},
{"data": "displayindString"},
{
    "className":      '',
    "orderable":      false,
    "data":           null,
    "defaultContent": '<button name="viewBtn" class="btn btn-primary" type="submit" form="datatableForm" formaction="<c:url value="/product/subcategory/viewSubCategory" />"><i class="fa fa-eye"></i> View</button>   <button name="editBtn" class="btn btn-primary" type="submit" form="datatableForm" formaction="<c:url value="/product/subcategory/updateSubCategory" />"><i class="fa fa-pencil"></i> Edit</button>'
},