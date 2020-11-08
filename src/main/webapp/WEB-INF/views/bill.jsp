<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@include file="./base.jsp" %>
</head>
<link rel="stylesheet" href="<c:url value="/resources/css/bill_css.css" />"  media='all'>
<body>
<script>
$(document).ready(function(){
	$('#printInvoice').click(function(){
		 var printContents =$('.invoice')[0].innerHTML;
        window.print();
	    
	});
});
</script>
<script>
function Popup(data) 
{
    window.print(data);
    return true;
}
</script>
<div id="invoice">

    <div class="toolbar hidden-print">
        <div class="text-right">
            <button id="printInvoice" class="btn btn-info"><i class="fa fa-print"></i> Print</button>
        </div>
        <hr>
    </div>
    <div class="invoice overflow-auto">
        <div style="min-width: 600px">
            <header>
                <div class="row">
                    <div class="col company-details">
                        <h2 class="name">
                            <a target="_blank" href="${pageContext.request.contextPath}/">
                            The Best Shop
                            </a>
                        </h2>
                        <div>Khajpura Patna-14</div>
                        <div>6204550539</div>
                        <div>company@example.com</div>
                    </div>
                </div>
            </header>
            <main>
                <div class="row contacts">
                    <div class="col invoice-to">
                        <div class="text-gray-light">INVOICE TO:</div>
                        <h2 class="to">${order.getCustomer_name()}</h2>
                        <div class="address">Mobile Number:- ${order.getCustomer_mobile_number()}</div>
                    </div>
                    <div class="col invoice-details">
                        <h1 class="invoice-id">Order ID ${order_id}</h1>
                        <div class="date">Date of Invoice: ${order.getOrder_date()}-${order.getMonth_year()}</div>
                    </div>
                </div>
                <table >
                    <thead>
                        <tr>
                      
                            <th class="text-left">DESCRIPTION</th>
                            <th class="text-right">PRICE</th>
                            <th class="text-right">Quantity</th>
                            <th class="text-right">TOTAL</th>
                        </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${products }" var="p">
                        <tr>
                            <td class="text-left"><h3>${p.getName()}</h3></td>
                            <td class="unit">${p.getPrice()}</td>
                            <td class="qty">${p.getQuantity()}</td>
                            <td class="total">${p.getPrice()*p.getQuantity()}</td>
                        </tr>
                        </c:forEach>
                    </tbody>
                    <tfoot>
                        <tr>
                            <td colspan="3">Grand TOTAL</td>
                            <td>${ total_price}</td>
                        </tr>
                    </tfoot>
                </table>
                <div class="thanks">Thank you!</div>
            </main>
            <footer>
                Invoice was created on a computer and is valid without the signature and seal.
            </footer>
        </div>
        <!--DO NOT DELETE THIS div. IT is responsible for showing footer always at the bottom-->
        <div></div>
    </div>
</div>
</body>
</html>