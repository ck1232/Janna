<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!-- Left side column. contains the logo and sidebar -->
  <aside class="main-sidebar">

    <!-- sidebar: style can be found in sidebar.less -->
    <section class="sidebar">

      <!-- Sidebar user panel (optional) -->
      <div class="user-panel">
        <div class="pull-left image">
          <img src="/JJ/development/dist/img/user2-160x160.jpg" class="img-circle" alt="User Image">
        </div>
        <div class="pull-left info">
          <p>Alexander Pierce</p>
          <!-- Status -->
          <a href="#"><i class="fa fa-circle text-success"></i> Online</a>
        </div>
      </div>

      <!-- search form (Optional) -->
      <form action="#" method="get" class="sidebar-form">
        <div class="input-group">
          <input type="text" name="q" class="form-control" placeholder="Search...">
              <span class="input-group-btn">
                <button type="submit" name="search" id="search-btn" class="btn btn-flat"><i class="fa fa-search"></i>
                </button>
              </span>
        </div>
      </form>
      <!-- /.search form -->

      <!-- Sidebar Menu -->
      <ul class="sidebar-menu">
        <li class="header">HEADER</li>
        <!-- Optionally, you can add icons to the links -->
        <li class="active"><a href="<c:url value="/listUser"/>"><i class="fa fa-users"></i> <span>User Management</span></a></li>
        <li><a href="<c:url value="/getUserList"/>"><i class="fa fa-link"></i> <span>Get User</span></a></li>
        <li><a href="<c:url value="/createUser"/>"><i class="fa fa-plus-square"></i> <span>Create User</span></a></li>
        <li class="treeview">
          <a href="#"><i class="fa fa-link"></i> <span>Multilevel</span>
            <span class="pull-right-container">
              <i class="fa fa-angle-left pull-right"></i>
            </span>
          </a>
          <ul class="treeview-menu">
            <li><a href="<c:url value="/hello"/>">hello</a></li>
            <li><a href="<c:url value="/contact"/>">contact 2</a></li>
          </ul>
        </li>
      </ul>
      <!-- /.sidebar-menu -->
    </section>
    <!-- /.sidebar -->
  </aside>