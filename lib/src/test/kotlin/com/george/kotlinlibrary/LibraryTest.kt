package com.george.kotlinlibrary

import kotlin.test.Test
import kotlin.test.assertContains

class LibraryTest {
    @Test fun testSayHello() {
        val output = Hello()
        assertContains(output.say("George"), "Hello, George")
    }
}
