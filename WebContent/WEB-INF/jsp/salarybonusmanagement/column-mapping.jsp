<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
{
    "className":      '',
    "orderable":      false,
    "data":           "",
    "defaultContent": '<div name="statusDiv" style="text-align:center;"><div style="text-align:center;"><input type="checkbox" name="checkboxId"/></div></div>'
},
{"data": "dateString"},
{"data": "name"},
{"data": "type"},
{"data": "grossAmt"},
{"data": "takehomeAmt"},
{"data": "bonusAmt"},
{"data": "status"},
{
    "className":      '',
    "orderable":      false,
    "data":           null,
    "defaultContent": '<button name="viewBtn" class="btn btn-primary" type="submit" form="viewSalaryBonusForm">View</button>'+
    '<div name="payBtnDiv"><button name="editBtn" class="btn btn-primary" type="submit" form="updateSalaryBonusForm"><i class="fa fa-pencil"></i> Edit</button>' + 
    '<button name="payBtn" class="btn btn-primary" type="submit" form="paySalaryBonusForm">Pay</button></div>'
    
},