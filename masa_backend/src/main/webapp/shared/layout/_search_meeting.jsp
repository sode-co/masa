<%@ page import="com.devlogs.masa_backend.common.Masa"%>


<div class="min-h-screen p-10 bg-gray-100">
  <div class="max-w-md mx-auto">
    <label for="select" class="block py-2 font-semibold">Search</label>

    <div class="relative">
      <div class="flex items-center h-10 bg-white border border-gray-200 rounded">
        <input name="select" id="searchkeyword" class="w-full px-4 text-gray-800 outline-none appearance-none" checked />

          <button onclick="search()"
                  class="text-gray-300 transition-all outline-none cursor-pointer focus:outline-none hover:text-gray-600">
            <svg
                    class="w-4 h-4 text-gray-600 fill-current"
                    xmlns="http://www.w3.org/2000/svg"
                    xmlns:xlink="http://www.w3.org/1999/xlink"
                    version="1.1"
                    id="Capa_1"
                    x="0px"
                    y="0px"
                    viewBox="0 0 56.966 56.966"
                    style="enable-background: new 0 0 56.966 56.966"
                    xml:space="preserve"
                    width="30px"
                    height="30px"

            >
                                <path
                                        d="M55.146,51.887L41.588,37.786c3.486-4.144,5.396-9.358,5.396-14.786c0-12.682-10.318-23-23-23s-23,10.318-23,23  s10.318,23,23,23c4.761,0,9.298-1.436,13.177-4.162l13.661,14.208c0.571,0.593,1.339,0.92,2.162,0.92  c0.779,0,1.518-0.297,2.079-0.837C56.255,54.982,56.293,53.08,55.146,51.887z M23.984,6c9.374,0,17,7.626,17,17s-7.626,17-17,17  s-17-7.626-17-17S14.61,6,23.984,6z"
                                />
                            </svg>
          </button>
        <select id="searchmethod" class="h-10 pl-5 pr-10 text-gray-600 bg-white border-0 appearance-none hover:border-0 focus:border-0">
          <option>Mentor</option>
          <option>Title</option>
        </select>
      </div>
    </div>
  </div>
</div>
<script>
    function search(){
      const searchMethod = document.getElementById("searchmethod").value;
      const searchKey = document.getElementById("searchkeyword").value;
      const urlForward = "${Masa.SERVER_HOST}/member/searchmeeting.jsp?method="+searchMethod+"&keyword="+searchKey;
      window.open(urlForward);
    }
</script>