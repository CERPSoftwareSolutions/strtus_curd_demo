<!doctype html>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<html>
<body>
    <div class="sidebar-main sidebar-menu-one sidebar-expand-md sidebar-color">
        <div class="mobile-sidebar-header d-md-none">
           <div class="header-logo">
               <a href="dashboard.html"><img src="static/img/logo1.png" alt="logo"></a>
               <input type="hidden" id="highlightmenu" value="<logic:present name='highlightname' scope='request'><bean:write name='highlightname' scope='request'/></logic:present>">
           </div>
        </div>
        <div class="sidebar-menu-content">
           <ul class="nav nav-sidebar-menu sidebar-toggle-view">
               <li class="nav-item sidebar-nav-item">
                   <a href="#" class="nav-link"><i class="flaticon-classmates"></i><span>Students</span></a>
                   <ul class="nav sub-group-menu">
                       <li class="nav-item">
                           <a href="studentregistration.do" class="nav-link" id="sub_module_2_1"><i class="fas fa-angle-right"></i>
                               Registration</a>
                        </li>
                   </ul>
               </li>
           </ul>
       </div>
   </div>

</body>
</html>
        