### URL shortener

Create an application (not web, in memory) that can handle:

1. Shortening of original URL by using provided SEO keyword. Keyword should be at
   max 20 symbols

**Input:** Original URL: https://blog.mysite.com/cool-article, Keyword: BEST-ARTICLE

**Output:** https://short.en/BEST-ARTICLE

2. Shortening of original URL, without provided keyword. Randomly generate 5
   alpha-numeric keyword

**Input:** Original URL: https://blog.mysite.com/another-article

**Output:** https://short.en/Pq34r

3. Retrieve original URL by shorten URL

**Input:** https://short.en/Pq34r

**Output:** https://blog.mysite.com/another-article
