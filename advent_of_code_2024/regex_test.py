dct_test = {"test": 1}



for key in dct_test.keys():
    new_key = f"{key}{dct_test[key]}"
    dct_test[new_key] = 1