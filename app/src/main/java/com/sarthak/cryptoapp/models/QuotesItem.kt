package com.sarthak.cryptoapp.models

data class QuotesItem(val marketCap: Double = 0.0,
                      val volumeH: Double = 0.0,
                      val marketCapByTotalSupply: Double = 0.0,
                      val percentChange1h: Double = 0.0,
                      val lastUpdated: String = "",
                      val percentChange24h: Double = 0.0,
                      val percentChange30D: Double = 0.0,
                      val price: Double = 0.0,
                      val ytdPriceChangePercentage: Double = 0.0,
                      val percentChange60D: Double = 0.0,
                      val name: String = "",
                      val percentChange7D: Double = 0.0,
                      val dominance: Double = 0.0,
                      val fullyDilluttedMarketCap: Double = 0.0,
                      val percentChangeH: Double = 0.0,
                      val turnover: Double = 0.0)