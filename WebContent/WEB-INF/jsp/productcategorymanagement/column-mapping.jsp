<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
{
    "className":      '',
    "orderable":      false,
    "data":           "",
    "defaultContent": '<div style="text-align:center;"><input type="checkbox" name="checkboxId"/></div>'
},
{"data": "categoryName"},
{"data": "isParentString"},
{"data": "displayIndString"},
{
    "className":      '',
    "orderable":      false,
    "data":           null,
    "defaultContent": '<button name="editBtn" class="btn btn-primary" type="submit" form="updateCategoryForm"><i class="fa fa-pencil"></i> Edit</button>'+
    '<button name="manageSubCategoryBtn" class="btn btn-primary" type="submit" form="datatableForm" formaction="<c:url value="/product/subcategory/listSubCategory" />"><i class="fa fa-pencil"></i> Manage SubCategory</button>'
},