import datetime
from numpy.distutils.fcompiler import none

last_id = 0

class Note:
    def __init__(self, memo, tags=''):
        self.memo = memo
        self.tags = tags
        self.creation_date = datetime.date.today()
        global last_id
        last_id = last_id + 1
        self.id = last_id
        
    def match(self, ifilter):
        return ifilter in self.memo or ifilter in self.tags
    
class NoteBook:
    def __init__(self):
        self.notes = []
    
    def new_note(self, memo, tags=''):
        self.notes.append(Note(memo, tags))
    
    def modify_memo(self, note_id, memo):
        self._find_note(note_id).memo = memo
            
    def modify_tags(self, note_id, tags):
        self._find_note(note_id).tags = tags
            
    def search(self, ifilter):
        return [note for note in self.notes if note.match(ifilter)]
    
    def _find_note(self, note_id):
        for note in self.notes:
            if str(note.id) == str(note_id):
                return note
            return none
    
    
        
        