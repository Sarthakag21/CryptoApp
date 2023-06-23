package com.sarthak.cryptoapp.models

import java.io.Serializable

data class CryptoCurrencyListItem(val symbol: String,
                                  val selfReportedCirculatingSupply: Double,
                                  val totalSupply: Double,
                                  val cmcRank: Double,
                                  val isActive: Double,
                                  val circulatingSupply: Double,
                                  val dateAdded: String,
                                  val tags: List<String>?,
                                  val quotes: List<QuotesItem>?,
                                  val lastUpdated: String,
                                  val isAudited: Boolean = false,
                                  val name: String,
                                  val marketPairCount: Double,
                                  val id: Int = 0,
                                  val maxSupply: Double,
                                  val slug: String) : Serializable{
    override fun equals(other: Any?): Boolean {
        return super.equals(other)
    }

    override fun hashCode(): Int {
        return super.hashCode()
    }

    override fun toString(): String {
        return super.toString()
    }
                                  }