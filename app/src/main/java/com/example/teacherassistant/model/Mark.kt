package com.example.teacherassistant.model

import java.util.*

data class Mark (val student: Student,
                 val subject: Subject,
                 val mark:Float,
                 val comment: String,
                 val date: String)