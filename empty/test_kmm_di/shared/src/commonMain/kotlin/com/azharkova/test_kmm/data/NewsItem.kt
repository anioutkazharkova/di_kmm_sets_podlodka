package com.azharkova.test_kmm.data

import kotlinx.serialization.SerialName

@kotlinx.serialization.Serializable
data class NewsItem(
    @SerialName("author") val author: String?,
    val title: String?, val description: String?,
    val url: String?, val urlToImage: String?,
    val publishedAt: String?,
    val content: String?
)


/*
* "author": "Al Root",
"title": "Don't Blame Logistics for Tesla's Deliveries Miss. There Is a Much Bigger Reason.",
"description": "Tesla shares are getting hammered after weaker-than-expected third-quarter delivery numbers. The reason isn't 'cars in transit.'",
"url": "https://www.barrons.com/articles/tesla-stock-deliveries-logistics-demand-51664814415",
"urlToImage": "https://images.barrons.com/im-635928/social",
"publishedAt": "2022-10-03T16:38:12Z",
"content": "Tesla\r\n stock was getting hammered after weaker-than-expected third-quarter delivery numbers. Wall Street seems to believe the shortfall was due to logistics. That isnt what investors are worried abo… [+2790 chars]"
* */