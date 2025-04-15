<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
  <title>커뮤니티 게시물 관리자 대시보드</title>
  <style>
    /* 기본 리셋 및 폰트 설정 */
    *, *::before, *::after {
      box-sizing: border-box;
      margin: 0;
      padding: 0;
    }
    body {
      font-family: 'Segoe UI', sans-serif;
      background-color: #F7F9FC; 
      display: flex;
      min-height: 100vh;
      color: #333;
    }
    a {
      text-decoration: none;
      color: inherit;
    }

    /* ===== 좌측 사이드바 (화이트 배경) ===== */
    .sidebar {
      width: 250px;
      background-color: #f1f3f5;     /* 화이트 or 아주 연한 회색 */
      color: #444;
      display: flex;
      flex-direction: column;
      border-right: 1px solid #E0E6ED;
      padding: 20px 15px;
    }
    /* 프로필 영역 */
    .sidebar .profile {
      display: flex;
      flex-direction: column;
      align-items: center;
      margin-bottom: 30px;
      padding-bottom: 20px;
      border-bottom: 1px solid #E0E6ED;
    }
    .profile img {
      width: 80px;
      height: 80px;
      border-radius: 50%;
      object-fit: cover;
      margin-bottom: 10px;
      border: 2px solid #ddd;
      background-color: #eee; /* 이미지를 못 불러올 때 대비 */
    }
    .profile .profile-info {
      text-align: center;
    }
    .profile-info .name {
      font-size: 15px;
      font-weight: bold;
      color: #333;
      margin-bottom: 4px;
    }
    .profile-info .role {
      font-size: 12px;
      color: #888;
    }

    /* 메뉴 리스트 */
    .menu {
      list-style: none;
      margin-top: 20px;
      flex: 1; /* 아래쪽 공간(로그아웃) 확보 위해 남은 공간 차지 */
    }
    .menu li {
      margin-bottom: 6px;
    }
    .menu li a {
      display: flex;
      align-items: center;
      gap: 10px;
      padding: 10px 15px;
      border-radius: 8px;
      color: #444;
      font-size: 14px;
      transition: background-color 0.3s, color 0.3s;
    }
    .menu li a .icon {
      width: 20px;
      text-align: center;
      color: #888;
      font-size: 16px;
    }
    .menu li a:hover {
      background-color: #f0f1f3;
      color: #2c3e50;
    }
    .menu li a.active {
      background-color: #e4e7ec;
      color: #2c3e50;
      font-weight: 600;
    }

    /* 로그아웃 버튼 (메뉴 하단에 별도 아이템) */
    .logout-item {
      margin-top: auto;
      border-top: 1px solid #E0E6ED;
      padding-top: 20px;
    }
    .logout-item a {
      display: flex;
      align-items: center;
      gap: 10px;
      padding: 10px 15px;
      border-radius: 8px;
      color: #444;
      font-size: 14px;
      transition: background-color 0.3s, color 0.3s;
    }
    .logout-item a .icon {
      width: 20px;
      text-align: center;
      color: #888;
      font-size: 16px;
    }
    .logout-item a:hover {
      background-color: #f0f1f3;
    }

    /* ============ 메인 컨테이너 ============ */
    .main-container {
      flex: 1;
      display: flex;
      flex-direction: column;
    }
    .topbar {
      height: 60px;
      background-color: #ffffff;
      border-bottom: 1px solid #E0E6ED;
      display: flex;
      align-items: center;
      justify-content: space-between;
      padding: 0 20px;
    }
    .topbar .page-title {
      font-size: 18px;
      font-weight: 600;
      color: #3C4B64;
    }
    .topbar .topbar-right {
      display: flex;
      align-items: center;
      gap: 20px;
    }
    .search-box {
      position: relative;
    }
    .search-box input {
      padding: 8px 35px 8px 12px;
      border: 1px solid #ccc;
      border-radius: 8px;
      outline: none;
      font-size: 14px;
    }
    .search-box::after {
      content: "🔍";
      position: absolute;
      right: 10px;
      top: 8px;
      font-size: 16px;
      color: #888;
    }
    .topbar-right button {
      background-color: #F7F9FC;
      border: none;
      font-size: 14px;
      color: #3C4B64;
      border-radius: 8px;
      padding: 8px 12px;
      cursor: pointer;
      transition: background-color 0.3s;
    }
    .topbar-right button:hover {
      background-color: #E9EDF2;
    }
    .content {
      flex: 1;
      padding: 20px;
      overflow-y: auto;
    }
    /* 통계 카드 섹션 */
    .stats-cards {
      display: grid;
      grid-template-columns: repeat(auto-fill, minmax(180px, 1fr));
      gap: 20px;
      margin-bottom: 20px;
    }
    .card {
      background-color: #fff;
      border: 1px solid #E0E6ED;
      border-radius: 8px;
      padding: 20px;
      box-shadow: 0 2px 4px rgba(0,0,0,0.03);
      display: flex;
      flex-direction: column;
    }
    .card h3 {
      font-size: 14px;
      color: #8A93A2;
      margin-bottom: 10px;
    }
    .card .count {
      font-size: 24px;
      font-weight: bold;
      color: #3C4B64;
    }
    .card .sub-info {
      font-size: 12px;
      color: #8A93A2;
      margin-top: 5px;
    }
    .charts {
      display: grid;
      grid-template-columns: 2fr 1fr;
      gap: 20px;
    }
    .chart-box {
      background-color: #fff;
      border: 1px solid #E0E6ED;
      border-radius: 8px;
      padding: 20px;
      box-shadow: 0 2px 4px rgba(0,0,0,0.03);
      margin-bottom: 20px;
    }
    .chart-box h4 {
      font-size: 14px;
      font-weight: 600;
      color: #3C4B64;
      margin-bottom: 10px;
    }
    .chart-placeholder {
      background-color: #f0f3f8;
      border: 1px dashed #ccc;
      border-radius: 6px;
      height: 200px;
      display: flex;
      align-items: center;
      justify-content: center;
      font-size: 14px;
      color: #999;
    }
    .posts-table {
      margin-top: 20px;
      background-color: #fff;
      border: 1px solid #E0E6ED;
      border-radius: 8px;
      box-shadow: 0 2px 4px rgba(0,0,0,0.03);
    }
    .posts-table h4 {
      font-size: 14px;
      font-weight: 600;
      color: #3C4B64;
      padding: 20px;
    }
    table {
      width: 100%;
      border-collapse: collapse;
      font-size: 13px;
      color: #3C4B64;
    }
    thead {
      background-color: #F7F9FC;
    }
    thead th {
      text-align: left;
      padding: 12px 20px;
      font-weight: 500;
      border-bottom: 1px solid #E0E6ED;
    }
    tbody td {
      padding: 12px 20px;
      border-bottom: 1px solid #E0E6ED;
    }
    tbody tr:hover {
      background-color: #fafcfe;
    }
    footer {
      height: 40px;
      display: flex;
      align-items: center;
      justify-content: center;
      background-color: #ffffff;
      border-top: 1px solid #E0E6ED;
      font-size: 12px;
      color: #8A93A2;
    }
    @media (max-width: 992px) {
      .charts {
        grid-template-columns: 1fr;
      }
    }
  </style>
</head>
<body>
	<!-- 좌측 사이드바 (화이트 배경, 프로필+로그아웃 수정) -->
	<aside class="sidebar">
		<!-- 프로필 영역 -->
		<div class="profile">
			<img src="/img/adm/admin.png" alt="Admin">
			<div class="profile-info">
				<div class="name">Admin</div>
				<div class="role">최고관리자</div>
			</div>
		</div>
		
		<!-- 메뉴 리스트 -->
		<ul class="menu">
			<li>
				<a href="#" class="active">
					<span class="icon">🏠</span> Dashboard
				</a>
			</li>
			<li>
				<a href="#">
					<span class="icon">👥</span> 회원 관리
				</a>
			</li>
			<li>
				<a href="#">
					<span class="icon">📋</span> 메뉴 관리
				</a>
			</li>
			<li>
				<a href="#">
					<span class="icon">📄</span> 컨텐츠 관리
				</a>
			</li>
			<li>
				<a href="#">
					<span class="icon">📝</span> 게시물 관리
				</a>
			</li>
			<li>
				<a href="#">
					<span class="icon">💬</span> 댓글/신고 관리
				</a>
			</li>
			<li>
				<a href="#">
					<span class="icon">📊</span> 회원 통계
				</a>
			</li>
			<li>
				<a href="#">
					<span class="icon">⚙️</span> 설정
				</a>
			</li>
		</ul>
		
		<!-- 로그아웃 버튼 (메뉴 하단) -->
		<div class="logout-item">
			<a href="#">
				<span class="icon">🔓</span> 로그아웃
			</a>
		</div>
	</aside>

	<!-- 메인 영역 -->
	<div class="main-container">
		<!-- 상단 헤더 -->
		<header class="topbar">
			<div class="page-title">커뮤니티 게시물 관리자</div>
			<div class="topbar-right">
				<div class="search-box">
					<input type="text" placeholder="검색어를 입력하세요" />
				</div>
				<button>알림</button>
				<button>로그아웃</button>
			</div>
		</header>
		
		<!-- 메인 컨텐츠 -->
		<div class="content">
			<!-- 통계 카드 섹션 -->
			<div class="stats-cards">
				<div class="card">
					<h3>전체 게시물</h3>
					<div class="count">12,345</div>
					<div class="sub-info">+12% (이번 달)</div>
				</div>
				<div class="card">
					<h3>전체 댓글</h3>
					<div class="count">67,890</div>
					<div class="sub-info">+8% (이번 달)</div>
				</div>
				<div class="card">
					<h3>신고된 게시물</h3>
					<div class="count">45</div>
					<div class="sub-info">-3% (이번 달)</div>
				</div>
				<div class="card">
					<h3>활성 회원수</h3>
					<div class="count">4,321</div>
					<div class="sub-info">+5% (이번 달)</div>
				</div>
			</div>
			
			<!-- 차트 섹션 -->
			<div class="charts">
				<div class="chart-box">
					<h4>게시물 증가 추이</h4>
					<div class="chart-placeholder">[Chart Placeholder]</div>
				</div>
				<div class="chart-box">
					<h4>인기 게시판 분석</h4>
					<div class="chart-placeholder">[Chart Placeholder]</div>
				</div>
			</div>

			<!-- 게시물 테이블 -->
			<div class="posts-table">
				<h4>최근 등록된 게시물</h4>
				<table>
					<thead>
						<tr>
							<th>번호</th>
							<th>제목</th>
							<th>작성자</th>
							<th>등록일</th>
							<th>상태</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>123</td>
							<td>첫 게시물 예시</td>
							<td>user01</td>
							<td>2025-04-10</td>
							<td>공개</td>
						</tr>
						<tr>
							<td>122</td>
							<td>문의합니다</td>
							<td>user02</td>
							<td>2025-04-09</td>
							<td>공개</td>
						</tr>
						<tr>
							<td>121</td>
							<td>버그 제보</td>
							<td>user03</td>
							<td>2025-04-09</td>
							<td>비공개</td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
		
		<!-- 하단 푸터 -->
		<footer>
			&copy; 2025 커뮤니티 관리자 대시보드. All rights reserved.
		</footer>
	</div>
</body>
</html>