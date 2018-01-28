import sys

from notebook import NoteBook
from Carbon.Aliases import true

class Menu:
    def __init__(self):
        self.notebook = NoteBook()
        self.choices = {
            "1" : self.show_notes,
            "2" : self.search_notes,
            "3" : self.add_note,
            "4" : self.modify_note,
            "5" : self.quit
            }
        
    def display_menu(self):
        print("""
Notebook Menu

1. Show all Notes
2. Search Notes
3. Add Note
4. Modify Note
5. Quit
""")
        
    def run(self):
        while true:
            self.display_menu()
            choice = input("Enter an option:")
            action = self.choices.get(str(choice))
            if action:
                action()
            else:
                print("{0} is not a valid choice".format(choice))
    
    def show_notes(self, notes=None):
        if not notes:
            notes = self.notebook.notes
        for note in notes:
            print("{0}: {1}\n{2}".format(note.id, note.tags, note.memo))
    
    def search_notes(self):
        ifilter = raw_input("Search for:")
        notes = self.notebook.search(ifilter)
        self.show_notes(notes)
        
    def add_note(self):
        memo = raw_input("Enter a memo:")
        print(memo)
        self.notebook.new_note(memo)
        print("Your note has been added.")
        
    def modify_note(self):
        note_id = raw_input("Enter a note id:")
        memo = raw_input("Enter a memo:")
        tags = raw_input("Enter tags:")
        if memo:
            self.notebook.modify_memo(note_id, memo)
        if tags:
            self.notebook.modify_tags(note_id, tags)
        
    def quit(self):
        sys.exit(0)
        
if __name__ == "__main__":
    aa = raw_input("test: ")
    print(aa)
    Menu().run()
    
