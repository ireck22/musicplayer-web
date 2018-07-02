#!/usr/bin/python
# -*- coding: utf-8 -*-


import pyaudio
import wave
import os


#define stream chunk   
#chunk = 1024  
  
#open a wav format music  
def music(): 
  f = u'/var/www/html/video3/music/chosesong.mp3'  
  os.system('mplayer "%s"' % f ) 

music() 
