package com.hiya

import com.android.build.gradle.internal.dsl.BuildType
import com.android.build.gradle.internal.dsl.SigningConfig
import com.android.build.gradle.api.AndroidSourceSet
import org.gradle.api.Action
import org.gradle.api.NamedDomainObjectContainer

/**
 * A bit of sugar on top of the Kotlin DSL. Enables the following:
 * ```
 * signingConfigs {
 *     debug { ... }
 * }
 * ```
 */
fun NamedDomainObjectContainer<SigningConfig>.debug(action: Action<SigningConfig>): SigningConfig = getByName("debug", action)

/**
 * A bit of sugar on top of the Kotlin DSL. Enables the following:
 * ```
 * signingConfigs {
 *     release { ... }
 * }
 * ```
 *
 * Implementation note: we need to use [NamedDomainObjectContainer.create] because there _is no_ default [SigningConfig]
 * named "release" (cf `SigningConfig.debug`)
 */
fun NamedDomainObjectContainer<SigningConfig>.release(action: Action<SigningConfig>): SigningConfig = create("release", action)

/**
 * A bit of sugar on top of the Kotlin DSL. Enables the following:
 * ```
 * buildTypes {
 *     debug { ... }
 * }
 * ```
 */
fun NamedDomainObjectContainer<BuildType>.debug(action: Action<BuildType>): BuildType = getByName("debug", action)

/**
 * A bit of sugar on top of the Kotlin DSL. Enables the following:
 * ```
 * buildTypes {
 *     release { ... }
 * }
 * ```
 */
fun NamedDomainObjectContainer<BuildType>.release(action: Action<BuildType>): BuildType = getByName("release", action)

/**
 * A bit of sugar on top of the Kotlin DSL. Enables the following:
 * ```
 * buildTypes {
 *     release { ... }
 * }
 * ```
 */
fun NamedDomainObjectContainer<BuildType>.sdk(action: Action<BuildType>): BuildType = create("sdk", action)

/**
 * A bit of sugar on top of the Kotlin DSL. Enables the following:
 * ```
 * sourceSets {
 *     main { ... }
 * }
 * ```
 */
fun NamedDomainObjectContainer<AndroidSourceSet>.main(action: Action<AndroidSourceSet>) = getByName("main", action)
fun NamedDomainObjectContainer<AndroidSourceSet>.androidTest(action: Action<AndroidSourceSet>) = getByName("androidTest", action)