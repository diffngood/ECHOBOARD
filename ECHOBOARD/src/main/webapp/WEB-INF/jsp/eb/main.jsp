<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<%@include file="_inc/title.jsp" %>

</head>
<body>
  <!-- 상단 헤더 -->
  <%@include file="_inc/header.jsp" %>

  <!-- Hero 섹션 -->
  <section class="hero">
    <h1>커뮤니티 최신 소식</h1>
  </section>

  <!-- 메인 컨테이너 -->
  <div class="main-wrapper">
    <!-- 좌측(최신글, 인기글, 추천글) -->
    <div class="content-left">
      <div class="post-tabs">
        <button class="tab active">최신글</button>
        <button class="tab">인기글</button>
        <button class="tab">추천글</button>
      </div>
      <div class="post-list">
        <div class="post-item">
          <a href="#">최신글 제목 1</a>
          <div class="meta">작성자: user01 | 2025-04-10 | 조회: 123</div>
        </div>
        <div class="post-item">
          <a href="#">최신글 제목 2</a>
          <div class="meta">작성자: user02 | 2025-04-09 | 조회: 98</div>
        </div>
      </div>
    </div>
    
    <!-- 우측(실시간 검색어) -->
    <div class="content-right">
      <div class="realtime-search">
        <h3>실시간 검색어</h3>
        <ul>
          <li>1. 검색어 예시</li>
          <li>2. 검색어 예시</li>
          <li>3. 검색어 예시</li>
          <li>4. 검색어 예시</li>
        </ul>
      </div>
    </div>
  </div>

  <!-- 오른쪽 바깥 광고 배너 -->
  <div class="ad-banner" id="adBanner">광고배너 160x550</div>

  <!-- 하단 영역 -->
  <div class="bottom-section">
    <section class="news-slick">
      <h3>뉴스 슬릭</h3>
      <div class="slick-items">
        <div class="slick-item">슬라이드1</div>
        <div class="slick-item">슬라이드2</div>
        <div class="slick-item">슬라이드3</div>
        <div class="slick-item">슬라이드4</div>
      </div>
    </section>
    <div class="menu-boards">
      <section class="board-section">
        <h4>메뉴1</h4>
        <div class="board-item">게시물1</div>
        <div class="board-item">게시물2</div>
        <div class="board-item">게시물3</div>
        <div class="board-item">게시물4</div>
      </section>
      <section class="board-section">
        <h4>메뉴2</h4>
        <div class="board-item">게시물1</div>
        <div class="board-item">게시물2</div>
        <div class="board-item">게시물3</div>
        <div class="board-item">게시물4</div>
      </section>
      <section class="board-section">
        <h4>메뉴3</h4>
        <div class="board-item">게시물1</div>
        <div class="board-item">게시물2</div>
        <div class="board-item">게시물3</div>
        <div class="board-item">게시물4</div>
      </section>
      <section class="board-section">
        <h4>메뉴4</h4>
        <div class="board-item">게시물1</div>
        <div class="board-item">게시물2</div>
        <div class="board-item">게시물3</div>
        <div class="board-item">게시물4</div>
      </section>
    </div>
  </div>

  <!-- 푸터 -->
  <%@include file="_inc/footer.jsp" %>

  <!-- JS: Footer와 겹치지 않도록 광고배너 위치 조정 (그대로 유지) -->
  <script>
    window.addEventListener('scroll', () => {
      const ad = document.getElementById('adBanner');
      const footer = document.querySelector('footer');

      // 광고 배너 기본 위치
      let adBaseTop = 320;
      const adHeight = ad.offsetHeight;
      const footerOffsetTop = footer.offsetTop;
      const scrollY = window.scrollY;

      const adBottomPos = adBaseTop + adHeight + scrollY;
      if (adBottomPos >= footerOffsetTop) {
        const overlap = adBottomPos - footerOffsetTop + 7;
        ad.style.top = (adBaseTop - overlap) + 'px';
      } else {
        ad.style.top = adBaseTop + 'px';
      }
    });
  </script>
</body>
</html>
