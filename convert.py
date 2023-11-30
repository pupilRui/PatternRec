from PIL import Image

# Convert JPG to BMP
def convert_jpg_to_bmp(input_file, output_file):
    jpg_image = Image.open(input_file)
    bmp_image = jpg_image.convert('RGB')
    bmp_image.save(output_file, 'BMP')
    jpg_image.close()

# Resize BMP to 10x10
def resize_bmp_to_10x10(input_file, output_file):
    bmp_image = Image.open(input_file)
    resized_image = bmp_image.resize((10, 10))
    resized_image.save(output_file, 'BMP')
    bmp_image.close()

# Specify input and output file paths
input_jpg_file = 'e.jpg'
temp_bmp_file = 'temp.bmp'
output_10x10_bmp_file = 'output_10x10.bmp'

# Convert JPG to BMP
convert_jpg_to_bmp(input_jpg_file, temp_bmp_file)

# Resize BMP to 10x10
resize_bmp_to_10x10(temp_bmp_file, output_10x10_bmp_file)

# Clean up the temporary BMP file
import os
os.remove(temp_bmp_file)

print(f"JPG image '{input_jpg_file}' converted to 10x10 BMP: '{output_10x10_bmp_file}'")
