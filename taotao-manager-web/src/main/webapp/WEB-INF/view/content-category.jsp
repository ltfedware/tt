<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div>
    <ul id="contentCategory" class="easyui-tree">
    </ul>
</div>

<!-- EasyUI菜单功能 -->
<div id="contentCategoryMenu" class="easyui-menu" style="width:120px;" data-options="onClick:menuHandler">
    <div data-options="iconCls:'icon-add',name:'add'">添加</div>
    <div data-options="iconCls:'icon-remove',name:'rename'">重命名</div>
    <div class="menu-sep"></div>
    <div data-options="iconCls:'icon-remove',name:'delete'">删除</div>
</div>
<script type="text/javascript">
    $(function(){
        //在id=contentCategory标签上绑定一个树节点
        $("#contentCategory").tree({
            url : '/rest/content/category',		//远程加载树结构数据
            animate: true,
            method : "GET",		//提交方式为GET

            //鼠标右键菜单事件
            onContextMenu: function(e,node){
                //屏蔽鼠标右键菜单默认事件
                e.preventDefault();

                //让当前树节点选中一个节点(当前鼠标右键菜单事件发生的节点)
                $(this).tree('select',node.target);

                //让id=contentCategoryMenu菜单显示
                $('#contentCategoryMenu').menu('show',{
                    left: e.pageX,
                    top: e.pageY
                });
            },

            //编辑之后   node=被编辑的节点队名
            onAfterEdit : function(node){
                //获取树节点对象
                var _tree = $(this);

                //节点id=0，则执行如下操作
                if(node.id == 0){
                    // 新增节点
                    $.post("/rest/content/category/add",{parentId:node.parentId,name:node.text},function(data){
                        //让编辑的树节点对象执行入下更新操作
                        _tree.tree("update",{
                            target : node.target,
                            id : data.id	//id=新增的节点id，数据库里的id数据值
                        });
                    });
                }else{
                    //重命名之后，执行编辑操作
                    $.ajax({
                        type: "POST",
                        url: "/rest/content/category/update",
                        data: {id:node.id,name:node.text},
                        success: function(msg){
                            //$.messager.alert('提示','新增成功!');
                        },
                        error: function(){
                            $.messager.alert('提示','重命名失败!');
                        }
                    });
                }
            }
        });
    });

    //菜单点击事件
    //item=是当前点击的菜单对象
    function menuHandler(item){
        //获取树节点对象
        var tree = $("#contentCategory");

        //获取树节点里面选中的节点
        var node = tree.tree("getSelected");

        //获取点击的菜单的name属性，如果属性的值=add
        if(item.name === "add"){
            //在树上追加一个子节点
            tree.tree('append', {
                parent: (node?node.target:null),	//确认父节点
                data: [{
                    text: '新建分类',			//新增的树节点显示文本
                    id : 0,					//新增树节点的ID默认值为0
                    parentId : node.id		//父节点ID为当前选中的节点ID
                }]
            });

            //找到整个树节点里id=0的节点
            var _node = tree.tree('find',0);

            //tree.tree("select",_node.target)  让id、=0的树节点选中
            //beginEdit  开启编辑状态
            tree.tree("select",_node.target).tree('beginEdit',_node.target);
        }else if(item.name === "rename"){
            //重命名   开启编辑状态
            tree.tree('beginEdit',node.target);
        }else if(item.name === "delete"){
            //如果菜单的name属性=delete则执行如下删除操作

            //弹出一个提示对话框
            $.messager.confirm('确认','确定删除名为 '+node.text+' 的分类吗？',function(r){
                if(r){
                    //点击确认之后，执行如下ajax请求
                    $.ajax({
                        type: "POST",
                        url: "/rest/content/category/delete",
                        data : {parentId:node.parentId,id:node.id},
                        success: function(msg){
                            //$.messager.alert('提示','新增商品成功!');
                            tree.tree("remove",node.target);
                        },
                        error: function(){
                            $.messager.alert('提示','删除失败!');
                        }
                    });
                }
            });
        }
    }
</script>