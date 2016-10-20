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
          <p>${user.username}</p>
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
        
        <c:forEach items="${menu.moduleList}" var="module">
        	<c:if test="${module.subModuleList != null}">
        		<c:choose>
        			<c:when test="${module.subModuleList.size() == 0}">
        			</c:when>
        			<c:when test="${module.subModuleList.size() == 1}">
					    <li class="active"><a href="<c:url value="${module.subModuleList.get(0).url}"/>"><i class="fa ${module.subModuleList.get(0).icon}"></i> <span>${module.subModuleList.get(0).name}</span></a></li>
					</c:when>
					<c:otherwise>
						<li class="treeview">
	          				<a href="#"><i class="fa ${module.icon}"></i> <span>${module.name}</span>
		            			<span class="pull-right-container">
		              				<i class="fa fa-angle-left pull-right"></i>
		            			</span>
	          				</a>
	          				<ul class="treeview-menu">
			          			<c:forEach items="${module.subModuleList}" var="submodule">
			          				 <li><a href="<c:url value="${submodule.url}"/>">${submodule.name}</a></li>
			          			</c:forEach>
	          				</ul>
          				</li>
					</c:otherwise>
        		</c:choose>
        		
        	</c:if>
        </c:forEach>
      </ul>
      <!-- /.sidebar-menu -->
    </section>
    <!-- /.sidebar -->
  </aside>