"""
Arrays in Python are strong typed. A type is required in order to create

Type code	C Type	                Python Type	    Minimum size (bytes)
'b'	        signed char	        int	                1	 
'B'	        unsigned char	        int	                1	 
'u'	        Py_UNICODE	        Unicode character	2	
'h'	        signed short	        int	                2	 
'H'	        unsigned short	        int	                2	 
'i'	        signed int	        int	                2	 
'I'	        unsigned int	        int	                2	 
'l'	        signed long	        int	                4	 
'L'	        unsigned long	        int	                4	 
'q'	        signed long long	int	                8	
'Q'	        unsigned long long	int	                8	
'f'	        float	                float	                4	 
'd'	        double	                float	                8	 

u will be deprecated in 3.3
"""

array.array('l', [12, 3040, 120033])
