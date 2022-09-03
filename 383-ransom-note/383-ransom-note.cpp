class Solution {
public:
    bool canConstruct(string ransomNote, string magazine) {
        if (ransomNote.size() > magazine.size()) return false;
        // alm -> Available Letter Map
        int alm[26] = { 0 };
        // Initializing because the array may contain some garbage values
        
        // Create an int alm map since both the strings only contain lowercase letters
        for (auto &letter : magazine) ++alm[letter - 'a'];
        
        // Check the alm
        for (auto &letter : ransomNote)
            if (--alm[letter - 'a'] < 0) return false;
        
        // Return true since everything is fine
        return true;
    }
};