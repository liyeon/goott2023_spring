<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>포트폴리오 사이트</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
		<div class="container">
			<a class="navbar-brand" href="#">포트폴리오 사이트</a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarNav"
				aria-controls="navbarNav" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarNav">
				<ul class="navbar-nav ml-auto">
					<li class="nav-item"><a class="nav-link" href="#">홈</a></li>
					<li class="nav-item"><a class="nav-link" href="#">포트폴리오</a></li>
					<li class="nav-item"><a class="nav-link" href="#">문의하기</a></li>
				</ul>
			</div>
		</div>
	</nav>

	<section class="portfolio-section py-5">
		<div class="container">
			<h2 class="text-center mb-4">포트폴리오</h2>
			<div class="row" id="portfolio-row"></div>
		</div>
	</section>

	<footer class="bg-dark text-white text-center py-3">
		<p>&copy; 2023 포트폴리오 사이트. All rights reserved.</p>
	</footer>

	<script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>
	<script>
  const portfolioRow = document.getElementById('portfolio-row');
  
  // Unsplash API에서 랜덤 이미지 URL 가져오는 함수
  async function getRandomImage() {
    try {
      const response = await axios.get('https://source.unsplash.com/random/400x300');
      return response.request.responseURL;
    } catch (error) {
      console.error('Error fetching image:', error);
    }
  }

  // 포트폴리오 아이템 생성 및 추가
  async function createPortfolioItem() {
    const imageUrl = await getRandomImage();
    
    const colDiv = document.createElement('div');
    colDiv.classList.add('col-md-4', 'mb-4');
    
    const portfolioItem = document.createElement('div');
    portfolioItem.classList.add('portfolio-item');
    
    const img = document.createElement('img');
    img.src = imageUrl;
    img.alt = '포트폴리오 이미지';
    img.classList.add('img-fluid');
    
    const title = document.createElement('h4');
    title.classList.add('mt-3');
    title.textContent = '프로젝트 제목';
    
    const description = document.createElement('p');
    description.textContent = '프로젝트에 대한 간단한 설명이 들어갑니다.';
    
    portfolioItem.appendChild(img);
    portfolioItem.appendChild(title);
    portfolioItem.appendChild(description);
    colDiv.appendChild(portfolioItem);
    portfolioRow.appendChild(colDiv);
  }

  // 포트폴리오 아이템 생성 호출
  for (let i = 0; i < 6; i++) {
    createPortfolioItem();
  }
</script>
</body>
</html>

