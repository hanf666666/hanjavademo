
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8"/>
    <style>
        body { font-family: "SimSun"; }
        .header { color: #1e88e5; }
        table { border-collapse: collapse; width: 100%; }
        th, td { border: 1px solid #ddd; padding: 8px; }
    </style>
</head>
<body>
<h1>${documentTitle}</h1>
<p>生成时间: ${.now?string("yyyy-MM-dd HH:mm:ss")}</p>

<table>
    <tr>
        <th>序号</th>
        <th>产品名称</th>
        <th>价格</th>
    </tr>
    <#list products as product>
        <tr>
            <td>${product?index + 1}</td>
            <td>${product.name}</td>
            <td>${product.price?string("0.00")}元</td>
        </tr>
    </#list>
</table>

<#if discountApplied>
    <div class="footer">注：已应用会员折扣</div>
</#if>
</body>
</html>
