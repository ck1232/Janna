<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
{
    "className":      '',
    "orderable":      false,
    "data":           "",
    "defaultContent": '<div style="text-align:center;"><input type="checkbox" name="checkboxId"/></div>'
},
{"data": "optionName"},
{"data": "subOptionList[, ].subOptionName"},
{
    "className":      '',
    "orderable":      false,
    "data":           null,
    "defaultContent": '<button name="editBtn" class="btn btn-primary" type="submit" form="editOptionForm"><i class="fa fa-pencil"></i> Edit</button>'
},