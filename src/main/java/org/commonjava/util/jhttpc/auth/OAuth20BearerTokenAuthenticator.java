/**
 * Copyright (C) 2015 Red Hat, Inc. (https://github.com/Commonjava/jhttpc)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.commonjava.util.jhttpc.auth;

import org.apache.http.Header;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicHeader;
import org.commonjava.util.jhttpc.JHttpCException;

import java.net.URL;
import java.util.Collections;

public class OAuth20BearerTokenAuthenticator
        extends ClientAuthenticator
{

    private static final String AUTHORIZATION_HEADER = "Authorization";

    private static final String BEARER_FORMAT = "Bearer %s";

    private final String token;

    public OAuth20BearerTokenAuthenticator( final String token )
    {
        this.token = token;
    }

    @Override
    public HttpClientBuilder decorateClientBuilder( final HttpClientBuilder builder )
            throws JHttpCException
    {
        final Header header = new BasicHeader( AUTHORIZATION_HEADER, String.format( BEARER_FORMAT, token ) );
        return builder.setDefaultHeaders( Collections.<Header> singleton( header ) );
    }

}
