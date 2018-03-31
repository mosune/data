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
    <title>大转盘</title>
</head>
<body class="gray-bg">
    <div class="wrapper wrapper-content animated fadeInRight">
        <div class="row">
            <div class="col-sm-12">
                <div class="ibox float-e-margins">
                    <div class="ibox-title">
                        <h5>大转盘</h5>
                    </div>
                    <div class="ibox-content">
                        <div class="row">
                            <div id="toolbar">
                                <button type="button" class="btn btn-primary btn-sm"><a href="index.jsp" style="color: white;">返回</a></button>
                            </div>
                            <div class="col-sm-12">
                                <table class="table table-striped table-bordered table-hover" id="wheelTable">
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
                            <div class="col-sm-6">
                                <div class="form-group">
                                    <label class="col-sm-4 control-label" for="used">券已使用：</label>
                                    <div class="col-sm-8">
                                        <input class="form-control" id="used" name="used" type="text" readonly="readonly" required="required" />
                                    </div>
                                </div>
                            </div>
                            <div class="col-sm-6">
                                <div class="form-group">
                                    <label class="col-sm-4 control-label" for="dated">券已过期：</label>
                                    <div class="col-sm-8">
                                        <input class="form-control" id="dated" name="dated" type="text" readonly="readonly" required="required" />
                                    </div>
                                </div>
                            </div>
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
    var _wheelTable;
    $(document).ready(function() {
        _wheelTable = $('#wheelTable').bootstrapTable({
            sidePagination:'server',//设置为服务器端分页
            url: '<%=root%>/wheel/list.do',
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
                {field: 'name',width: '15%', title: '门店名称', align: 'center'},
                {field: 'isChain', width: '5%', title: '门店类型', align: 'center',
                    formatter: function(value){
                        if(value == 0) return "门店";
                        else if (value == 1) return "品牌";
                        else return "-";
                    }},
                {field: 'title',width: '15%', title: '大转盘名称', align: 'center'},
                {field: 'createTime',width: '10%', title: '创建时间', align: 'center',
                    formatter : function(value) {
                        return $(this).dateFormat(value, 'yyyy-MM-dd HH:mm:ss');
                    }},
                {field: 'startDate',width: '10%', title: '活动开始时间', align: 'center',
                    formatter : function(value) {
                        return $(this).dateFormat(value, 'yyyy-MM-dd HH:mm:ss');
                    }},
                {field: 'endDate',width: '10%', title: '活动结束时间', align: 'center',
                    formatter : function(value) {
                        return $(this).dateFormat(value, 'yyyy-MM-dd HH:mm:ss');
                    }},
                {field: 'entryType',width: '10%', title: '转盘类型', align: 'center',
                    formatter: function(value){
                        if(value == 'FLEXIBLE') return "多个转盘";
                        else if (value == 'STANDARD') return "标准转盘";
                        else return "其他";
                    }},
                {field: 'status',width: '10%', title: '状态', align: 'center',
                    formatter: function(value){
                        if(value == 'ON') return "进行中";
                        else if (value == 'OFF') return "已结束";
                        else if (value == 'DEL') return "已删除";
                        else if (value == 'NEW') return "未启用";
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
                {field: 'joinCount',width: '5%', title: '参与人数', align: 'center'},
                {field: 'joinNum',width: '5%', title: '参与次数', align: 'center'},
                {field: 'getLottery',width: '5%', title: '已中奖', align: 'center'},
                {field: 'notGetLottery',width: '5%', title: '未中奖', align: 'center'},
                {field: 'integralLottery',width: '5%', title: '积分中奖', align: 'center'},
                {field: 'ticketLottery',width: '5%', title: '券中奖', align: 'center'},
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
        $.ajax({
            type: 'post',
            url: '<%=root%>/wheel/getData.do',
            data: {id:id},
            dataType: 'json',
            async:false,
            success: function(data){
                $("#used").val(data.ticketUsed);
                $("#dated").val(data.ticketPast);
            }
        });
    }
</script>
</html>