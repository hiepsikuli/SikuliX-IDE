/*
 * Copyright 2010-2013, Sikuli.org
 * Released under the MIT License.
 *
 * modified RaiMan 2013
 */
package org.sikuli.ide.util;

import java.awt.image.*;
import java.util.Date;

public class LoadingSpinner {
   protected GifDecoder _gif;
   protected long _start_t = 0;
   protected int _curFrame_i = 0;
   protected BufferedImage _curFrame = null;

   public LoadingSpinner(){
      _gif = new GifDecoder();
      _gif.read(getClass().getResourceAsStream("/icons/loading.gif"));
      _curFrame = _gif.getFrame(0);
   }

   public BufferedImage getFrame(){
      int delay = _gif.getDelay(_curFrame_i);
      long now = (new Date()).getTime();
      if(now - _start_t >= delay){
         _start_t = now;
         _curFrame_i = (_curFrame_i+1) % _gif.getFrameCount();
         _curFrame = _gif.getFrame(_curFrame_i);
      }
      return _curFrame;
   }
}
