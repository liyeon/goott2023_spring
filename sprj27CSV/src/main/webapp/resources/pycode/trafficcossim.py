import pandas as pd
import numpy as np
#bookdf1=pd.read_csv('bookinfo.csv')
bookdf1=pd.read_csv('/Users/klyeon/git/goott2023_spring/sprj27CSV/src/main/webapp/resources/pycode/bookinfo.csv')


from sklearn.feature_extraction.text import TfidfVectorizer
tfidf=TfidfVectorizer(stop_words='english')

tfidf_matrix_book=tfidf.fit_transform(bookdf1['bstory'])

from sklearn.metrics.pairwise import linear_kernel
cosine_sim_book=linear_kernel(tfidf_matrix_book,tfidf_matrix_book)
indices_book=pd.Series(bookdf1.index,index=bookdf1['btitle']).drop_duplicates()

bookdf1.columns=['no', 'btitle', 'bstory', 'bwriter', 'bpub', 'bprice', 'bdate']

def get_recommendations_book(btitle,cosine_sim_book=cosine_sim_book):
    #영화 제목을 통해서 전체 데이터 기준 그 영화의 index값을 가져오기
    idx_book=indices_book[btitle]
    sim_scores_book=list(enumerate(cosine_sim_book[idx_book]))
    # 코사인 유사도매트릭스 cosine_sim에서 idx에 해당하는 데이터를 (idx, 유사도)
    sim_scores_book=sorted(sim_scores_book,key=lambda x:x[1],reverse=True)
    # 코사인 유사도 기준으로 내림차순정렬
    sim_scores_book=sim_scores_book[1:7] 
    # 자신을 제외한 7개의 추천 영화를 슬라이싱
    # 추천서적목록 인덱스 정보 추출
    movie_indices_book=[i[0] for i in sim_scores_book]
    return bookdf1['btitle'].iloc[movie_indices_book]

print(get_recommendations_book('업무의 잔머리 '))