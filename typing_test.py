import time

def typing_test():
    sentence = "The quick brown fox jumps over the lazy dog."
    print("Type this sentence:")
    print(sentence)
    input("Press Enter when ready...")

    start_time = time.time()
    user_input = input("\nStart typing here:\n")
    end_time = time.time()

    # Calculate time
    time_taken = end_time - start_time
    time_in_minutes = time_taken / 60

    # Calculate words per minute
    word_count = len(sentence.split())
    wpm = word_count / time_in_minutes

    # Calculate accuracy
    correct_chars = sum(1 for a, b in zip(user_input, sentence) if a == b)
    accuracy = (correct_chars / len(sentence)) * 100

    # Results
    print("\n--- Results ---")
    print(f"Time taken: {time_taken:.2f} seconds")
    print(f"Words per minute: {wpm:.2f}")
    print(f"Accuracy: {accuracy:.2f}%")

typing_test()