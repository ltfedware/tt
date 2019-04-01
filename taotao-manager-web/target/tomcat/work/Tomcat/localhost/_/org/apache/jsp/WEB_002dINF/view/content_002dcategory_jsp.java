/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2017-11-14 08:16:46 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.view;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class content_002dcategory_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("<div>\r\n");
      out.write("    <ul id=\"contentCategory\" class=\"easyui-tree\">\r\n");
      out.write("    </ul>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("<!-- EasyUI菜单功能 -->\r\n");
      out.write("<div id=\"contentCategoryMenu\" class=\"easyui-menu\" style=\"width:120px;\" data-options=\"onClick:menuHandler\">\r\n");
      out.write("    <div data-options=\"iconCls:'icon-add',name:'add'\">添加</div>\r\n");
      out.write("    <div data-options=\"iconCls:'icon-remove',name:'rename'\">重命名</div>\r\n");
      out.write("    <div class=\"menu-sep\"></div>\r\n");
      out.write("    <div data-options=\"iconCls:'icon-remove',name:'delete'\">删除</div>\r\n");
      out.write("</div>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("    $(function(){\r\n");
      out.write("        //在id=contentCategory标签上绑定一个树节点\r\n");
      out.write("        $(\"#contentCategory\").tree({\r\n");
      out.write("            url : '/rest/content/category',\t\t//远程加载树结构数据\r\n");
      out.write("            animate: true,\r\n");
      out.write("            method : \"GET\",\t\t//提交方式为GET\r\n");
      out.write("\r\n");
      out.write("            //鼠标右键菜单事件\r\n");
      out.write("            onContextMenu: function(e,node){\r\n");
      out.write("                //屏蔽鼠标右键菜单默认事件\r\n");
      out.write("                e.preventDefault();\r\n");
      out.write("\r\n");
      out.write("                //让当前树节点选中一个节点(当前鼠标右键菜单事件发生的节点)\r\n");
      out.write("                $(this).tree('select',node.target);\r\n");
      out.write("\r\n");
      out.write("                //让id=contentCategoryMenu菜单显示\r\n");
      out.write("                $('#contentCategoryMenu').menu('show',{\r\n");
      out.write("                    left: e.pageX,\r\n");
      out.write("                    top: e.pageY\r\n");
      out.write("                });\r\n");
      out.write("            },\r\n");
      out.write("\r\n");
      out.write("            //编辑之后   node=被编辑的节点队名\r\n");
      out.write("            onAfterEdit : function(node){\r\n");
      out.write("                //获取树节点对象\r\n");
      out.write("                var _tree = $(this);\r\n");
      out.write("\r\n");
      out.write("                //节点id=0，则执行如下操作\r\n");
      out.write("                if(node.id == 0){\r\n");
      out.write("                    // 新增节点\r\n");
      out.write("                    $.post(\"/rest/content/category/add\",{parentId:node.parentId,name:node.text},function(data){\r\n");
      out.write("                        //让编辑的树节点对象执行入下更新操作\r\n");
      out.write("                        _tree.tree(\"update\",{\r\n");
      out.write("                            target : node.target,\r\n");
      out.write("                            id : data.id\t//id=新增的节点id，数据库里的id数据值\r\n");
      out.write("                        });\r\n");
      out.write("                    });\r\n");
      out.write("                }else{\r\n");
      out.write("                    //重命名之后，执行编辑操作\r\n");
      out.write("                    $.ajax({\r\n");
      out.write("                        type: \"POST\",\r\n");
      out.write("                        url: \"/rest/content/category/update\",\r\n");
      out.write("                        data: {id:node.id,name:node.text},\r\n");
      out.write("                        success: function(msg){\r\n");
      out.write("                            //$.messager.alert('提示','新增成功!');\r\n");
      out.write("                        },\r\n");
      out.write("                        error: function(){\r\n");
      out.write("                            $.messager.alert('提示','重命名失败!');\r\n");
      out.write("                        }\r\n");
      out.write("                    });\r\n");
      out.write("                }\r\n");
      out.write("            }\r\n");
      out.write("        });\r\n");
      out.write("    });\r\n");
      out.write("\r\n");
      out.write("    //菜单点击事件\r\n");
      out.write("    //item=是当前点击的菜单对象\r\n");
      out.write("    function menuHandler(item){\r\n");
      out.write("        //获取树节点对象\r\n");
      out.write("        var tree = $(\"#contentCategory\");\r\n");
      out.write("\r\n");
      out.write("        //获取树节点里面选中的节点\r\n");
      out.write("        var node = tree.tree(\"getSelected\");\r\n");
      out.write("\r\n");
      out.write("        //获取点击的菜单的name属性，如果属性的值=add\r\n");
      out.write("        if(item.name === \"add\"){\r\n");
      out.write("            //在树上追加一个子节点\r\n");
      out.write("            tree.tree('append', {\r\n");
      out.write("                parent: (node?node.target:null),\t//确认父节点\r\n");
      out.write("                data: [{\r\n");
      out.write("                    text: '新建分类',\t\t\t//新增的树节点显示文本\r\n");
      out.write("                    id : 0,\t\t\t\t\t//新增树节点的ID默认值为0\r\n");
      out.write("                    parentId : node.id\t\t//父节点ID为当前选中的节点ID\r\n");
      out.write("                }]\r\n");
      out.write("            });\r\n");
      out.write("\r\n");
      out.write("            //找到整个树节点里id=0的节点\r\n");
      out.write("            var _node = tree.tree('find',0);\r\n");
      out.write("\r\n");
      out.write("            //tree.tree(\"select\",_node.target)  让id、=0的树节点选中\r\n");
      out.write("            //beginEdit  开启编辑状态\r\n");
      out.write("            tree.tree(\"select\",_node.target).tree('beginEdit',_node.target);\r\n");
      out.write("        }else if(item.name === \"rename\"){\r\n");
      out.write("            //重命名   开启编辑状态\r\n");
      out.write("            tree.tree('beginEdit',node.target);\r\n");
      out.write("        }else if(item.name === \"delete\"){\r\n");
      out.write("            //如果菜单的name属性=delete则执行如下删除操作\r\n");
      out.write("\r\n");
      out.write("            //弹出一个提示对话框\r\n");
      out.write("            $.messager.confirm('确认','确定删除名为 '+node.text+' 的分类吗？',function(r){\r\n");
      out.write("                if(r){\r\n");
      out.write("                    //点击确认之后，执行如下ajax请求\r\n");
      out.write("                    $.ajax({\r\n");
      out.write("                        type: \"POST\",\r\n");
      out.write("                        url: \"/rest/content/category/delete\",\r\n");
      out.write("                        data : {parentId:node.parentId,id:node.id},\r\n");
      out.write("                        success: function(msg){\r\n");
      out.write("                            //$.messager.alert('提示','新增商品成功!');\r\n");
      out.write("                            tree.tree(\"remove\",node.target);\r\n");
      out.write("                        },\r\n");
      out.write("                        error: function(){\r\n");
      out.write("                            $.messager.alert('提示','删除失败!');\r\n");
      out.write("                        }\r\n");
      out.write("                    });\r\n");
      out.write("                }\r\n");
      out.write("            });\r\n");
      out.write("        }\r\n");
      out.write("    }\r\n");
      out.write("</script>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}