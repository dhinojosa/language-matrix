from array import *

"""Arrays are available in Python, but Lists are usually used.
Arrays can used the u code to create an array of Strings but will be deprecated"""


"""
Arrays in Python are strong typed. A type is required in order to create

Type code	C Type	                Python Type	    Minimum size (bytes)
'b'	        signed char	            int	                1
'B'	        unsigned char	        int	                1
'u'	        Py_UNICODE	            Unicode character	2
'h'	        signed short	        int	                2
'H'	        unsigned short	        int	                2
'i'	        signed int	            int	                2
'I'	        unsigned int	        int	                2
'l'	        signed long	            int	                4
'L'	        unsigned long	        int	                4
'q'	        signed long long	    int	                8
'Q'	        unsigned long long	    int	                8
'f'	        float	                float	            4
'd'	        double	                float	            8

u will be deprecated in 3.3
"""

"""Generate an Array of Integer"""
a = array('i', [12, 3040, 120033])
print(a)

"""array.typecode property that displays the typecode character used to create the array."""
print(a.typecode)

"""array.buffer_info()
Return a tuple (address, length) giving the current memory address and the length in elements of the buffer used to hold array’s contents. The size of the memory buffer in bytes can be computed as array.buffer_info()[1] * array.itemsize. This is occasionally useful when working with low-level (and inherently unsafe) I/O interfaces that require memory addresses, such as certain ioctl() operations. The returned numbers are valid as long as the array exists and no length-changing operations are applied to it."""

print(a.buffer_info())

