package org.apache.xml.security.algorithms.encryption.implementations.BC;

import org.apache.xml.security.utils.EncryptionConstants;

/**
 *
 * @author $Author$
 */
public class KeyWrapImpl_AES192_BC extends KeyWrapImpl {

  public int engineGetIvLength() {
    return -1;
  }
  public String getImplementedAlgorithmURI() {
    return EncryptionConstants.ALGO_ID_KEYWRAP_AES192;
  }
  public String getRequiredProviderName() {
      return "BC";
   }

}