param(
    $folder_name
)

mkdir $folder_name
cp .\puzzle_start.py $folder_name\puzzle_1.py
New-Item $folder_name\puzzle_2.py
New-Item $folder_name\puzzle_input
New-Item $folder_name\test_input