<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
{
    "className":      '',
    "orderable":      false,
    "data":           "",
    "defaultContent": '<div name="statusDiv" style="text-align:center;"><input type="checkbox" name="checkboxId"/></div>'
},
{	"data": "expenseDate",
	"render": function (data) {
                 var date = new Date(data);
        		var month = date.getMonth();
        		var monthNames = [
							    "January", "February", "March",
							    "April", "May", "June", "July",
							    "August", "September", "October",
							    "November", "December"
							  ];
        		return date.getDate() + " " + monthNames[month] + " " + date.getFullYear();
             }
},
{"data": "expensetype"},
{"data": "description"},
{"data": "totalAmt"},
{"data": "supplier"},
{"data": "status"},
{
    "className":      '',
    "orderable":      false,
    "data":           null,
    "width":		  "200px",
    "defaultContent": '<div class="outer">'+
    '<div class="inner"><button name="viewBtn" class="btn btn-primary" type="submit" form="viewExpenseForm">View</button></div>'+
    '<div name="payBtnDiv"><button name="editBtn" class="btn btn-primary" type="submit" form="updateExpenseForm"><i class="fa fa-pencil"></i> Edit</button>' +
    '<button name="payBtn" class="btn btn-primary" type="submit" form="payExpenseForm">Pay</button></div>'+
    '</div>'
},