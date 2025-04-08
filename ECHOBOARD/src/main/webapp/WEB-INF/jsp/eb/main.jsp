<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
  <%@include file="_inc/title.jsp"%>
</head>
<body>
<%@include file="_inc/header.jsp"%>
  <!-- 주요 배너/공지 영역 -->
  <section class="banner">
    <div class="notice-carousel">
      <h2>공지사항 및 이벤트 배너</h2>
      <p>여기에 슬라이드 형식의 배너가 들어갑니다.</p>
    </div>
  </section>

  <!-- 메인 콘텐츠 및 사이드바 -->
  <div class="container">
    <!-- 좌측 메인 콘텐츠 영역 -->
    <main class="main-content">
      <div class="tabs">
        <button class="tab active">최신글</button>
        <button class="tab">인기글</button>
        <button class="tab">추천글</button>
      </div>
      <div class="post-list">
        <article class="post-item">
          <h2 class="post-title"><a href="/post/123">게시글 제목 예시</a></h2>
          <div class="post-meta">
            <span class="author">작성자</span>
            <span class="date">2025-04-08</span>
            <span class="views">조회 123</span>
            <span class="comments">댓글 4</span>
          </div>
        </article>
        <article class="post-item">
          <h2 class="post-title"><a href="/post/124">또 다른 게시글 예시</a></h2>
          <div class="post-meta">
            <span class="author">작성자</span>
            <span class="date">2025-04-07</span>
            <span class="views">조회 98</span>
            <span class="comments">댓글 2</span>
          </div>
        </article>
        <!-- 추가 게시글 항목 반복 -->
      </div>
    </main>

    <!-- 우측 사이드바 -->
    <aside class="sidebar">
      <section class="hot-posts">
        <h3>오늘의 인기글</h3>
        <ul>
          <li><a href="/post/456">인기 글 제목 1</a></li>
          <li><a href="/post/789">인기 글 제목 2</a></li>
          <li><a href="/post/890">인기 글 제목 3</a></li>
        </ul>
      </section>
      <section class="ads">
        <h3>광고 배너</h3>
        <p>광고 배너 자리입니다.</p>
      </section>
    </aside>
  </div>

  <%@include file="_inc/footer.jsp"%>
</body>
</html>
