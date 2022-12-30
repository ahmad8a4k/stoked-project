package com.example.utils


import com.example.security.SaltedHash
import com.example.utils.Constants.SALTED_HASH_ALGORITHM
import org.apache.commons.codec.binary.Hex
import org.apache.commons.codec.digest.DigestUtils
import org.ktorm.database.Database
import org.ktorm.dsl.*
import org.ktorm.schema.Column
import java.security.SecureRandom
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

fun Database.checkIfExistByName(columnName: Column<String>, name: String): Boolean {
    return this.from(columnName.table).select().where { columnName eq name }.map {}.isNotEmpty()
}

fun String.stringToLocalDateTime(): LocalDateTime {
    return LocalDateTime.parse(this, DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));
}

fun String.generateSaltedHash(): SaltedHash {
    // Get Random Salt Number
    val salt = SecureRandom.getInstance(SALTED_HASH_ALGORITHM).generateSeed(32)
    // Hex Encoder for Salt
    val saltAsHex = Hex.encodeHexString(salt)
    // Hash SaltAsHex With User Password
    // Now, We Have
    // Hash( Hex(salt) + value)
    val hash = DigestUtils.sha256Hex("$saltAsHex$this")
    return SaltedHash(hash = hash, salt = saltAsHex)
}

fun SaltedHash.verifyPassword(password: String): Boolean {
    return DigestUtils.sha256Hex(salt + password) == hash
}