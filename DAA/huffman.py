class HuffmanNode:
    def __init__(self, char, freq):
        self.char = char
        self.freq = freq
        self.left = None
        self.right = None

    def __lt__(self, other):
        return self.freq < other.freq

def build_huffman_tree(data):
    # Count character frequencies
    frequency = {}
    for char in data:
        if char in frequency:
            frequency[char] += 1
        else:
            frequency[char] = 1

    # Create a list of Huffman nodes
    nodes = [HuffmanNode(char, freq) for char, freq in frequency.items()]

    # Build the Huffman tree
    while len(nodes) > 1:
        # Sort the list by frequency in ascending order
        nodes.sort(key=lambda x: x.freq)
        
        # Take the two lowest frequency nodes
        left = nodes.pop(0)
        right = nodes.pop(0)
        
        # Create a parent node with the combined frequency
        merged_node = HuffmanNode(None, left.freq + right.freq)
        merged_node.left = left
        merged_node.right = right
        
        # Add the parent node back to the list
        nodes.append(merged_node)

    return nodes[0]

def build_huffman_codes(node, code, result):
    if node.char is not None:
        result[node.char] = code
    if node.left:
        build_huffman_codes(node.left, code + '0', result)
    if node.right:
        build_huffman_codes(node.right, code + '1', result)

def huffman_encode(data):
    root = build_huffman_tree(data)
    huffman_codes = {}
    build_huffman_codes(root, '', huffman_codes)

    encoded_data = ''.join(huffman_codes[char] for char in data)
    return encoded_data, huffman_codes

def huffman_decode(encoded_data, huffman_codes):
    reverse_codes = {code: char for char, code in huffman_codes.items()}

    decoded_data = ''
    code = ''
    for bit in encoded_data:
        code += bit
        if code in reverse_codes:
            decoded_data += reverse_codes[code]
            code = ''

    return decoded_data

data =input("Enter input characters:-") 
encoded_data, huffman_codes = huffman_encode(data)
decoded_data = huffman_decode(encoded_data, huffman_codes)

print("Original data:", data)
print("Encoded data:", encoded_data)
print("Decoded data:", decoded_data)
