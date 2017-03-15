<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
{
    "className":      '',
    "orderable":      false,
    "data":           "",
    "defaultContent": '<div name="statusDiv" style="text-align:center;"><input type="checkbox" name="checkboxId"/></div>'
},
{"data": "invoiceid"},
{"data": "messenger"},
{"data": "totalprice"},
{"data": "status"},
{"data": "invoicedate"},
{
    "className":      '',
    "orderable":      false,
    "data":           null,
    "defaultContent": '<div name="payBtnDiv"><button name="payBtn" class="btn btn-primary" type="submit" form="payInvoiceForm">Pay</button></div>'+
    '<button name="viewBtn" class="btn btn-primary" type="submit" form="viewInvoiceForm">View</button>'
},