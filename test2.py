#!/usr/bin/python
# -*- coding: utf8 -*-
# coding: utf8
import time
import sys
import os
import speech_recognition
import pyaudio
import wave
import pygame
 

pygame.mixer.init()
pygame.mixer.music.load("/var/www/html/video3/music/chosesong.mp3")
pygame.mixer.music.play()
time.sleep(3)



r=speech_recognition.Recognizer()

with speech_recognition.Microphone() as source:
    audio=r.listen(source)
	#audio=r.record(source)
text = ""
text = r.recognize_google(audio, language='zh-TW')
#text = r.recognize_google(audio, language='en-US')

	
#if text == "":
	# time.sleep(600)
#else:

text= text.encode('utf_8')
time.sleep(3)
print text	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
#try:
    # for testing purposes, we're just using the default API key
    # to use another API key, use `r.recognize_google(audio, key="GOOGLE_SPEECH_RECOGNITION_API_KEY")`
    # instead of `r.recognize_google(audio)`
#	print text
#except speech_recognition.UnknownValueError:
 #   print("UnknownValueError")
#except speech_recognition.RequestError as e:
 #   print("RequestError ".format(e))
#os.system('pause')

