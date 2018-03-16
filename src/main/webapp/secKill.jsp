<%@ page isELIgnored="false" language="java"
         contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
    String root = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <link href="<%=root %>/resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="<%=root %>/resources/css/bootstrap-table.min.css" rel="stylesheet" />
    <link href="<%=root %>/resources/css/animate.min.css" rel="stylesheet">
    <link href="<%=root %>/resources/css/style.min.css" rel="stylesheet">

    <script src="<%=root %>/resources/js/jquery-2.1.1.min.js"></script>
    <script src="<%=root %>/resources/js/bootstrap.min.js"></script>
    <script src="<%=root %>/resources/js/bootstrap-table.js"></script>
    <script src="<%=root %>/resources/js/bootstrap-table-zh-CN.js"></script>
    <script src="<%=root %>/resources/js/jquery.extends.js"></script>
    <title>秒杀</title>
</head>
<body class="gray-bg">
    <div class="wrapper wrapper-content animated fadeInRight">
        <div class="row">
            <div class="col-sm-12">
                <div class="ibox float-e-margins">
                    <div class="ibox-title">
                        <h5>秒杀</h5>
                    </div>
                    <div class="ibox-content">
                        <div class="row">
                            <div class="col-sm-12">
                                <table class="table table-striped table-bordered table-hover" id="secKillTable">
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
<script type="text/javascript">
    var _secKillTable;
    $(document).ready(function() {
        _secKillTable = $('#secKillTable').bootstrapTable({
            sidePagination:'server',//设置为服务器端分页
            url: '<%=root%>/secKill/list.do',
            method: 'post',
            contentType: 'application/x-www-form-urlencoded;charset=utf-8',
            striped: true,
            pagination: true,
            pageList: [10,30,50],
            showToggle: true,
            showRefresh: true,
            showColumns: true,
            sortable: true,
            idField: 'id',
            columns: [
                {field: 'id',width: '10%', title: 'id', align: 'center'},
                {field: 'shopId',width: '10%', title: '商店id', align: 'center'},
                {field: 'shopName',width: '10%', title: '商店名称', align: 'center'},
                {field: 'isChain', width: '10%', title: '商店类型', align: 'center',
                    forma},
                {field: 'secKillName',width: '15%', title: '秒杀活动名称', align: 'center'},
                {field: 'startTime',width: '10%', title: '活动开始时间', align: 'center'},
                {field: 'endTime',width: '10%', title: '活动结束时间', align: 'center'},
                {field: 'status',width: '10%', title: '活动状态', align: 'center'},
                {field: 'cate',width: '10%', title: '行业', align: 'center'}
            ],
            toolbar: '#toolbar'
        });
    });
</script>
</html>