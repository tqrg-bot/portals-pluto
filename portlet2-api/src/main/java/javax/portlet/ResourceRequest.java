/*  Licensed to the Apache Software Foundation (ASF) under one
 *  or more contributor license agreements.  See the NOTICE file
 *  distributed with this work for additional information
 *  regarding copyright ownership.  The ASF licenses this file
 *  to you under the Apache License, Version 2.0 (the
 *  "License"); you may not use this file except in compliance
 *  with the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing,
 *  software distributed under the License is distributed on an
 *  "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *  KIND, either express or implied.  See the License for the
 *  specific language governing permissions and limitations
 *  under the License.
 */
/*
 * NOTE: this source code is based on an early draft version of JSR 286 and not intended for product
 * implementations. This file may change or vanish in the final version of the JSR 286 specification.
 */
/*
 * This source code implements specifications defined by the Java
 * Community Process. In order to remain compliant with the specification
 * DO NOT add / change / or delete method signatures!
 */
/**
  * Copyright 2006 IBM Corporation.
  */
package javax.portlet;

/**
 * The <code>ResourceRequest</code> interface represents the request
 * send to the portlet for rendering resources.
 * 
 * It extends the ClientDataRequest interface and provides resource request
 * information to portlets.
 * <p>
 * The portlet container creates an <CODE>ResourceRequest</CODE> object and
 * passes it as argument to the portlet's <CODE>serveResource</CODE> method.
 * <p>
 * The <code>ResourceRequest</code> is provided with the current portlet mode, window state, 
 * and render parameters that the portlet can access via the 
 * <code>PortletResourceRequest</code> with <code>getPortletMode</code> and, 
 * <code>getWindowState</code>, or one of the <code>getParameter</code> methods.   
 * ResourceURLs cannot change the current portlet mode, window state or 
 * render parameters . Parameters set on a resource URL are not render parameters 
 * but parameters for renderserving this resource and will last olnyonly for only 
 * this the current serveResource request.<br>
 * If a parameter is set that has the same name as a render parameter that this 
 * resource URL contains, the render parameter must be the last entry in the 
 * parameter value array. 
 * 
 * @see ClientDataRequest
 * @see ResourceServingPortlet
 * @since 2.0
 */
public interface ResourceRequest extends ClientDataRequest {

    /**
     * This property is set by the container if the container
     * has a cached response for the given validation tag. The property can be
     * retrieved using the <code>getProperty</code> method. 
     * <P>
     * The value is <code>"portlet.ETag "</code>.
     */
    public static final String ETAG = "portlet.ETag";

    /**
     * Returns the validation tag if the portlet container
     * has a cached response for this validation tag, or
     * <code>null</code> if no cached response exists.
     * <p>
     * This call returns the same value as 
     * <code>ResourceRequest.getProperty(ResourceRequest.ETAG)</code>.
     * 
     * @return  the validation tag if the portlet container
     *          has a cached response for this validation tag, or
     *          <code>null</code> if no cached response exists.
     */
    public String getETag();
    
    /**
     * Returns the resource ID set on the ResourceURL or <code>null</code>
     * if no resource ID was set onj the URL.
     * 
     * @return  the resource ID set on the ResourceURL,or <code>null</code>
     *          if no resource ID was set on the URL. 
     */
    public String getResourceID();
    
}
