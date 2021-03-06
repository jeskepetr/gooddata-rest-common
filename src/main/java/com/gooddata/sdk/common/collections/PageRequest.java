/*
 * Copyright (C) 2004-2019, GoodData(R) Corporation. All rights reserved.
 * This source code is licensed under the BSD-style license found in the
 * LICENSE.txt file in the root directory of this source tree.
 */
package com.gooddata.sdk.common.collections;

import com.gooddata.sdk.common.util.MutableUri;
import org.springframework.web.client.RestOperations;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

/**
 * Defines logic for generating page URIs.
 */
public interface PageRequest {

    /**
     * Creates {@link URI} for this page request.
     * <p>
     * Use {@link #updateWithPageParams(MutableUri)} if you have URI template and only want to update it with
     * page query params.
     *
     * @param mutableUri mutable URI used for generating page URI
     * @return compiled page URI
     */
    URI getPageUri(final MutableUri mutableUri);

    /**
     * Updates provided mutable URI query params according to this page configuration.
     * <p>
     * As {@link #getPageUri(MutableUri)} returns expanded page URI it is not very useful for cases that
     * require use of URI template with URI variables. This method allows you to use URI templates and benefit
     * from pagination support implemented in {@link PageRequest} implementations. It is especially useful if you need to handle
     * multiple requests of the same URI template in the same way - e.g. monitor request made by {@link RestOperations}
     * methods.
     * <p>
     * Use this in the situation when you have URI template with placeholders and URI variables separately.
     * This method is useful when you have URI template with placeholders and only want to add query parameters based
     * on this page to it.
     * <p>
     * Use {@link #getPageUri(MutableUri)} if you want to get specific page URI and don't have URI template.
     *
     * @param mutableUri URI builder used for constructing page URI
     * @return provided and updated mutable URI instance
     * @see RestOperations
     */
    MutableUri updateWithPageParams(final MutableUri mutableUri);
}
