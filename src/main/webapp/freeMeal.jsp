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
    <title>霸王餐</title>
</head>
<body class="gray-bg">
    <div class="wrapper wrapper-content animated fadeInRight">
        <div class="row">
            <div class="col-sm-12">
                <div class="ibox float-e-margins">
                    <div class="ibox-title">
                        <h5>霸王餐</h5>
                    </div>
                    <div class="ibox-content">
                        <div class="row">
                            <div id="toolbar">
                                <button type="button" class="btn btn-primary btn-sm"><a href="index.jsp" style="color: white;">返回</a></button>
                            </div>
                            <div class="col-sm-12">
                                <table class="table table-striped table-bordered table-hover" id="freeMealTable">
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <div class="modal fade" style="display: none;" data-keyboard="false" data-backdrop="static" id="modal" aria-hidden="true" role="dialog" aria-labelledby="modalHeader">
        <div class="modal-dialog modal-lg" role="document">
            <div class="modal-content">
                <div class="modal-body">
                    <form id="myForm" class="form-horizontal">
                        <div class="row">
                            <table class="table table-striped table-bordered table-hover" id="statusTable">
                            </table>
                        </div>
                    </form>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal" id="closeModal">关闭</button>
                </div>
            </div>
        </div>
    </div>
</body>
<script type="text/javascript">
    var _freeMealTable;
    $(document).ready(function() {
        _freeMealTable = $('#freeMealTable').bootstrapTable({
            sidePagination:'server',//设置为服务器端分页
            url: '<%=root%>/freeMeal/list.do',
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
                {field: 'shopId',width: '10%', title: '门店id', align: 'center'},
                {field: 'shopName',width: '15%', title: '门店名称', align: 'center'},
                {field: 'isChain', width: '5%', title: '门店类型', align: 'center',
                    formatter: function(value){
                        if(value == 0) return "门店";
                        else if (value == 1) return "品牌";
                        else return "-";
                    }},
                {field: 'freeMealName',width: '15%', title: '活动名称', align: 'center'},
                {field: 'createTime',width: '10%', title: '创建时间', align: 'center',
                    formatter : function(value) {
                        return $(this).dateFormat(value, 'yyyy-MM-dd HH:mm:ss');
                    }},
                {field: 'startTime',width: '10%', title: '活动开始时间', align: 'center',
                    formatter : function(value) {
                        return $(this).dateFormat(value, 'yyyy-MM-dd HH:mm:ss');
                    }},
                {field: 'endTime',width: '10%', title: '活动结束时间', align: 'center',
                    formatter : function(value) {
                        return $(this).dateFormat(value, 'yyyy-MM-dd HH:mm:ss');
                    }},
                {field: 'awardTime',width: '10%', title: '开奖时间', align: 'center',
                    formatter : function(value) {
                        return $(this).dateFormat(value, 'yyyy-MM-dd HH:mm:ss');
                    }},
                {field: 'status',width: '10%', title: '活动状态', align: 'center',
                    formatter: function(value){
                        if(value == 'START_LOTTERY') return "开始抽奖";
                        else if (value == 'END_JOIN') return "报名截止";
                        else if (value == 'START_JOIN') return "开始报名";
                        else if (value == 'NEW') return "未开始";
                        else if (value == 'END_LOTTERY') return "活动结束";
                        else if (value == 'OFF') return "活动关闭";
                        else return "其他";
                    }},
                {field: 'cate',width: '10%', title: '行业', align: 'center',
                    formatter: function(value){
                        if(value == 'BAR') return "酒吧";
                        else if (value == 'KTV') return "KTV";
                        else if (value == 'BEAUTY') return "丽人";
                        else if (value == 'DR') return "餐厅";
                        else if (value == 'HT') return "酒店";
                        else if (value == 'FB') return "足浴";
                        else return "其他";
                    }},
                {field: 'realJoinNo',width: '10%', title: '报名人数', align: 'center'},
                {field: 'awardNo',width: '10%', title: '中奖名额', align: 'center'},
                {field: 'getAwardNo',width: '10%', title: '中奖人数', align: 'center'},
                {field: 'cate',width: '10%', title: '操作', align: 'center',
                    formatter: function(value, row){
                        return '<button type="button" class="btn btn-info btn-xs" onclick="openModel(\''+row.id+'\')">查看</button>';
                    }}
            ],
            toolbar: '#toolbar'
        });
    });

    function openModel(id) {
        $("#modal").modal("show");
        var _statusTable;
        _statusTable = $('#statusTable').bootstrapTable({
            sidePagination:'server',//设置为服务器端分页
            url: '<%=root%>/freeMeal/getStatus.do',
            method: 'post',
            contentType: 'application/x-www-form-urlencoded;charset=utf-8',
            striped: true,
            queryParams : function(params) {
                params.id = id;
                return params;
            },
            columns: [
                {field: 'status',width: '50%', title: '订单状态', align: 'center',
                    formatter: function(value){
                        if(value == 'EXPIRED') return "过期";
                        else if (value == 'PICKED') return "已使用";
                        else if (value == 'ABATED') return "撤销";
                        else if (value == 'NORMAL') return "正常";
                        else if (value == 'SENT') return "已经赠送";
                        else if (value == 'WAIT_CONFIRM') return "待确认";
                        else if (value == 'WAIT_PICK') return "待配送";
                        else if (value == 'REFUND_SUCCESS') return "退款成功";
                        else if (value == 'LOCKED') return "锁定";
                        else return "其他";
                    }},
                {field: 'count',width: '50%', title: '数量', align: 'center'}
            ],
        });
    }

    $("#modal").on("hidden.bs.modal", function() {
        $("#statusTable").bootstrapTable('destroy');
    });
</script>
</html>