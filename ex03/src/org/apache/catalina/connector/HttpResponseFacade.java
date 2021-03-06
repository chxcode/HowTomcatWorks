/*
 * $Header: /home/cvs/jakarta-tomcat-4.0/catalina/src/share/org/apache/catalina/connector/HttpResponseFacade.java,v 1.5 2001/09/28 16:53:49 remm Exp $
 * $Revision: 1.5 $
 * $Date: 2001/09/28 16:53:49 $
 *
 * ====================================================================
 *
 * The Apache Software License, Version 1.1
 *
 * Copyright (c) 1999 The Apache Software Foundation.  All rights
 * reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 * 1. Redistributions of source code must retain the above copyright
 *    notice, this list of conditions and the following disclaimer.
 *
 * 2. Redistributions in binary form must reproduce the above copyright
 *    notice, this list of conditions and the following disclaimer in
 *    the documentation and/or other materials provided with the
 *    distribution.
 *
 * 3. The end-user documentation included with the redistribution, if
 *    any, must include the following acknowlegement:
 *       "This product includes software developed by the
 *        Apache Software Foundation (http://www.apache.org/)."
 *    Alternately, this acknowlegement may appear in the software itself,
 *    if and wherever such third-party acknowlegements normally appear.
 *
 * 4. The names "The Jakarta Project", "Tomcat", and "Apache Software
 *    Foundation" must not be used to endorse or promote products derived
 *    from this software without prior written permission. For written
 *    permission, please contact apache@apache.org.
 *
 * 5. Products derived from this software may not be called "Apache"
 *    nor may "Apache" appear in their names without prior written
 *    permission of the Apache Group.
 *
 * THIS SOFTWARE IS PROVIDED ``AS IS'' AND ANY EXPRESSED OR IMPLIED
 * WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES
 * OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED.  IN NO EVENT SHALL THE APACHE SOFTWARE FOUNDATION OR
 * ITS CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
 * SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
 * LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF
 * USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT
 * OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF
 * SUCH DAMAGE.
 * ====================================================================
 *
 * This software consists of voluntary contributions made by many
 * individuals on behalf of the Apache Software Foundation.  For more
 * information on the Apache Software Foundation, please see
 * <http://www.apache.org/>.
 *
 * [Additional notices, if required by prior licensing conditions]
 *
 */


package org.apache.catalina.connector;


import org.apache.catalina.HttpResponse;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * Facade class that wraps a Catalina-internal <b>HttpResponse</b>
 * object.  All methods are delegated to the wrapped response.
 *
 * @author Remy Maucherat
 * @author Craig R. McClanahan
 * @version $Revision: 1.5 $ $Date: 2001/09/28 16:53:49 $
 */

public final class HttpResponseFacade
    extends ResponseFacade
    implements HttpServletResponse {


    // ----------------------------------------------------------- Constructors


    /**
     * Construct a wrapper for the specified response.
     *
     * @param response The response to be wrapped
     */
    public HttpResponseFacade(HttpResponse response) {
        super(response);
    }


    // -------------------------------------------- HttpServletResponse Methods


    public void addCookie(Cookie cookie) {

        if (isCommitted())
            return;

        ((HttpServletResponse) response).addCookie(cookie);

    }


    public boolean containsHeader(String name) {
        return ((HttpServletResponse) response).containsHeader(name);
    }


    public String encodeURL(String url) {
        return ((HttpServletResponse) response).encodeURL(url);
    }


    public String encodeRedirectURL(String url) {
        return ((HttpServletResponse) response).encodeRedirectURL(url);
    }


    public String encodeUrl(String url) {
        return ((HttpServletResponse) response).encodeURL(url);
    }


    public String encodeRedirectUrl(String url) {
        return ((HttpServletResponse) response).encodeRedirectURL(url);
    }


    public void sendError(int sc, String msg)
        throws IOException {

        if (isCommitted())
            throw new IllegalStateException
                (/*sm.getString("responseBase.reset.ise")*/);

        resp.setAppCommitted(true);

        ((HttpServletResponse) response).sendError(sc, msg);

    }


    public void sendError(int sc)
        throws IOException {

        if (isCommitted())
            throw new IllegalStateException
                (/*sm.getString("responseBase.reset.ise")*/);

        resp.setAppCommitted(true);

        ((HttpServletResponse) response).sendError(sc);

    }


    public void sendRedirect(String location)
        throws IOException {

        if (isCommitted())
            throw new IllegalStateException
                (/*sm.getString("responseBase.reset.ise")*/);

        resp.setAppCommitted(true);

        ((HttpServletResponse) response).sendRedirect(location);

    }


    public void setDateHeader(String name, long date) {

        if (isCommitted())
            return;

        ((HttpServletResponse) response).setDateHeader(name, date);

    }


    public void addDateHeader(String name, long date) {

        if (isCommitted())
            return;

        ((HttpServletResponse) response).addDateHeader(name, date);

    }


    public void setHeader(String name, String value) {

        if (isCommitted())
            return;

        ((HttpServletResponse) response).setHeader(name, value);

    }


    public void addHeader(String name, String value) {

        if (isCommitted())
            return;

        ((HttpServletResponse) response).addHeader(name, value);

    }


    public void setIntHeader(String name, int value) {

        if (isCommitted())
            return;

        ((HttpServletResponse) response).setIntHeader(name, value);

    }


    public void addIntHeader(String name, int value) {

        if (isCommitted())
            return;

        ((HttpServletResponse) response).addIntHeader(name, value);

    }


    public void setStatus(int sc) {

        if (isCommitted())
            return;

        ((HttpServletResponse) response).setStatus(sc);

    }


    public void setStatus(int sc, String sm) {

        if (isCommitted())
            return;

        ((HttpServletResponse) response).setStatus(sc, sm);

    }


}
