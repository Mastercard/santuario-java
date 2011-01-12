/*
 * Copyright 1999-2011 The Apache Software Foundation.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *
 */
/*
 * Copyright 2005 Sun Microsystems, Inc. All rights reserved.
 */
/*
 * $Id: DigesterOutputStream.java,v 1.5 2005/12/20 20:02:39 mullan Exp $
 */
package org.jcp.xml.dsig.internal;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.MessageDigest;
import java.util.logging.Logger;
import java.util.logging.Level;

import org.apache.xml.security.utils.UnsyncByteArrayOutputStream;

/**
 * This class has been modified slightly to use java.security.MessageDigest
 * objects as input, rather than 
 * org.apache.xml.security.algorithms.MessageDigestAlgorithm objects.
 * It also optionally caches the input bytes.
 *
 * @author raul
 * @author Sean Mullan
 */
public class DigesterOutputStream extends OutputStream {
    private final boolean buffer;
    private UnsyncByteArrayOutputStream bos;
    private final MessageDigest md;
    private static Logger log = Logger.getLogger("org.jcp.xml.dsig.internal");

    /**
     * Creates a DigesterOutputStream.
     *
     * @param md the MessageDigest
     */
    public DigesterOutputStream(MessageDigest md) {
	this(md, false);
    }

    /**
     * Creates a DigesterOutputStream.
     *
     * @param md the MessageDigest
     * @param buffer if true, caches the input bytes
     */
    public DigesterOutputStream(MessageDigest md, boolean buffer) {
        this.md = md;
	this.buffer = buffer;
	if (buffer) {
	    bos = new UnsyncByteArrayOutputStream();
	}
    }

    public void write(int input) {
	if (buffer) {
	    bos.write(input);
	}
	md.update((byte)input);
    }
    
    @Override
    public void write(byte[] input, int offset, int len) {
	if (buffer) {
	    bos.write(input, offset, len);
	}
        if (log.isLoggable(Level.FINER)) {
	    log.log(Level.FINER, "Pre-digested input:");
	    StringBuffer sb = new StringBuffer(len);
            for (int i=offset; i<(offset+len); i++) {
		sb.append((char)input[i]);
            }
	    log.log(Level.FINER, sb.toString());
	}
	md.update(input, offset, len);
    }
    
    /**
     * @return the digest value 
     */
    public byte[] getDigestValue() {
         return md.digest();   
    }

    /**
     * @return an input stream containing the cached bytes, or
     *    null if not cached
     */
    public InputStream getInputStream() {
	if (buffer) {
	    return new ByteArrayInputStream(bos.toByteArray());
	} else {
	    return null;
	}
    }
}
